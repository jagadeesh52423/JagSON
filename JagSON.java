package com.appsec;

import org.jooq.tools.json.JSONArray;
import org.jooq.tools.json.JSONObject;

class JagSON
{
  public JSONObject ParseSQL(JSONObject input)
  {
    JSONObject output=new JSONObject();
    try {
      JSONArray fields= (JSONArray) input.get("fields");
      String keys[] = new String[fields.size()];
//    String types[] = new String[fields.size()];
      for(int i=0;i<fields.size();i++)
      {
        JSONObject key = (JSONObject) fields.get(i);
        keys[i] = key.get("name").toString();
//      types[i] = key.get("type").toString();
//      logger.info(key.toString());
      }
      JSONArray records=(JSONArray) input.get("records");
      JSONArray table = new JSONArray();
      for(int i = 0; i < records.size(); i++)
      {
        JSONArray record = (JSONArray)records.get(i);
        JSONObject row = new JSONObject();
        for(int j = 0; j < fields.size(); j++)
        {
          row.put(keys[j],record.get(j));
        }
        table.add(row);
      }
      output.put("data",table);
      return output;
    }
    catch (Exception e)
    {

    }
    return output;
  }
}

