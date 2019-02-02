package httpRequests;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modells.TableData;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Created by Loving on 24.01.2019.
 */
public class HttpRequests {
    private URI url = URI.create("http://localhost:8080/");

    public boolean dataPost(JSONObject jsonObject, String temp) {
        url = URI.create(url.toString() + temp);
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost postRequest = new HttpPost(url);
        StringEntity se = null;
        Boolean responseServer = false;
        try {
            se = new StringEntity(jsonObject.toString(), "UTF-8");
            se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            postRequest.setEntity(se);
            HttpResponse response = client.execute(postRequest);
            responseServer = (response != null) ? true : false;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseServer;
    }

    public boolean departPut(JSONObject jsonObject) {
        url = URI.create(url.toString() + "departure/");
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPut put = new HttpPut(url);
        StringEntity stringEntity = null;
        boolean responseServer = false;
        try {
            stringEntity = new StringEntity(jsonObject.toString(), "UTF-8");
            stringEntity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            put.setEntity(stringEntity);
            HttpResponse response = client.execute(put);
            responseServer = (response != null) ? true : false;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseServer;
    }

    public List<TableData> getAll(String temp, int langId) {
        System.out.println(temp);
        List<TableData> tableDatas = new ArrayList<TableData>();
        url = URI.create(url.toString() + temp);
        System.out.println(url);
//        tableShowD.getItems().clear();
        HttpResponse response;
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(url);

        try {
            response = client.execute(get);
            String jsonString = EntityUtils.toString(response.getEntity(), "UTF-8");
            JSONArray jsonArray = new JSONArray(jsonString);
            if (temp.contains("departure/")) {

                for (int i = 0; i < jsonArray.length(); i++) {

                    System.out.println("Jsoni uzinliqi:" + jsonArray.length());
                    TableData tableData = new TableData();
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    tableData.setId((long) (i + 1));
                    tableData.setTime(jsonObject.getString("time"));
                    tableData.setFlight(jsonObject.getString("flight"));
                    tableData.setTerminal(jsonObject.getString("terminal"));
                    /*------- Rasm get qilish ----------*/
                    String img = jsonObject.getString("logo");
                    byte[] dd = Base64.getDecoder().decode(img);
                    BufferedImage bf = ImageIO.read(new ByteArrayInputStream(dd));
                    Image img1 = SwingFXUtils.toFXImage(bf, null);
                    tableData.setImageView(new ImageView(img1));
                    /*----------------------------------*/
                    if (langId == 1) {
                        tableData.setDestination(jsonObject.getString("destinationUzb"));
                        if (jsonObject.getString("status").equals("schedule")) {
                            tableData.setStatus("jadval asosida");
                        }
                        if (jsonObject.getString("status").equals("expected")) {
                            tableData.setStatus(jsonObject.getString("statusTime") + " da kutilmoqda");
                        }
                        if (jsonObject.getString("status").equals("arrive")) {
                            tableData.setStatus(jsonObject.getString("statusTime") + " da keldi");
                        }
                        if (jsonObject.getString("status").equals("cancel")) {
                            tableData.setStatus("qoldirildi");
                        }

                    }
                    if (langId == 2) {
                        tableData.setDestination(jsonObject.getString("destinationEng"));
                        if (jsonObject.getString("status").equals("schedule")) {
                            tableData.setStatus("schedule");
                        }
                        if (jsonObject.getString("status").equals("expected")) {
                            tableData.setStatus("expected " + jsonObject.getString("statusTime"));
                        }
                        if (jsonObject.getString("status").equals("arrive")) {
                            tableData.setStatus("arrive " + jsonObject.getString("statusTime"));
                        }
                        if (jsonObject.getString("status").equals("cancel")) {
                            tableData.setStatus("cancel");
                        }

                    }
                    if (langId == 3) {
                        tableData.setDestination(jsonObject.getString("destinationRus"));
                        if (jsonObject.getString("status").equals("schedule")) {
                            tableData.setStatus("по расписанию");
                        }
                        if (jsonObject.getString("status").equals("expected")) {
                            tableData.setStatus("ожидается в " + jsonObject.getString("statusTime"));
                        }
                        if (jsonObject.getString("status").equals("arrive")) {
                            tableData.setStatus("прибил в " + jsonObject.getString("statusTime"));
                        }
                        if (jsonObject.getString("status").equals("cancel")) {
                            tableData.setStatus("отменён");
                        }

                    }

                    tableDatas.add(tableData);
                    //   tableData.setTime(jsonObject.getString("statusTime"));
                    //  tableData.setTerminal(jsonObject.getString("terminal"));
                }

            } else {
                for (int i = 0; i < jsonArray.length(); i++) {
                    TableData tableData = new TableData();
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    tableData.setId((long) (i + 1));
                    tableData.setTime(jsonObject.getString("time"));
                    tableData.setFlight(jsonObject.getString("flight"));

                    System.out.println("Jsoni uzinliqi:" + jsonArray.length());

                    /*------- Rasm get qilish ----------*/
                    String img = jsonObject.getString("logo");
                    byte[] dd = Base64.getDecoder().decode(img);
                    BufferedImage bf = ImageIO.read(new ByteArrayInputStream(dd));
                    Image img1 = SwingFXUtils.toFXImage(bf, null);
                    tableData.setImageView(new ImageView(img1));
                    /*----------------------------------*/


                    if (langId == 1) {
                        tableData.setDestination(jsonObject.getString("destinationUzb"));
                        if (jsonObject.getString("status").equals("schedule")) {
                            tableData.setStatus("jadval asosida");
                        }
                        if (jsonObject.getString("status").equals("expected")) {
                            tableData.setStatus(jsonObject.getString("statusTime") + " da kutilmoqda");
                        }
                        if (jsonObject.getString("status").equals("arrive")) {
                            tableData.setStatus(jsonObject.getString("statusTime") + " da keldi");
                        }
                        if (jsonObject.getString("status").equals("cancel")) {
                            tableData.setStatus("qoldirildi");
                        }

                    }
                    if (langId == 2) {
                        tableData.setDestination(jsonObject.getString("destinationEng"));
                        if (jsonObject.getString("status").equals("schedule")) {
                            tableData.setStatus("schedule");
                        }
                        if (jsonObject.getString("status").equals("expected")) {
                            tableData.setStatus("expected " + jsonObject.getString("statusTime"));
                        }
                        if (jsonObject.getString("status").equals("arrive")) {
                            tableData.setStatus("arrive " + jsonObject.getString("statusTime"));
                        }
                        if (jsonObject.getString("status").equals("cancel")) {
                            tableData.setStatus("cancel");
                        }

                    }
                    if (langId == 3) {
                        tableData.setDestination(jsonObject.getString("destinationRus"));
                        if (jsonObject.getString("status").equals("schedule")) {
                            tableData.setStatus("по расписанию");
                        }
                        if (jsonObject.getString("status").equals("expected")) {
                            tableData.setStatus("ожидается в " + jsonObject.getString("statusTime"));
                        }
                        if (jsonObject.getString("status").equals("arrive")) {
                            tableData.setStatus("прибил в " + jsonObject.getString("statusTime"));
                        }
                        if (jsonObject.getString("status").equals("cancel")) {
                            tableData.setStatus("отменён");
                        }

                    }

                    tableDatas.add(tableData);
                    System.out.println(tableData.getId());


                  /*
                       "id": 10,
                       "departDate": "2019-01-25",
                       "time": "12:23",
                       "flight": "HY 966",
                       "destinationUzb": "Urganch",
                       "destinationEng": "Urgench",
                       "destinationRus": "Ургенч",
                       "status": "arrive",
                       "statusTime": "12:50",
                       "terminal": "2 "
                   */
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            for (int i = 0; i < tableDatas.size(); i++) {
                System.out.println(tableDatas.get(i).getId());
            }
            return tableDatas;
        }

    }

    public JSONObject getById(Long id) {
        url = URI.create(url.toString() + "departure/");
        JSONObject jsonObject = null;
        HttpResponse httpResponse;
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(url + "id=" + id);

        try {
            httpResponse = client.execute(get);
            String jsonString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            jsonObject = new JSONObject(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }


}
