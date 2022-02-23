package com.flywolf.li.framework.configcenter.utils;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.FileNameMap;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtils
{
  public static final String FILE_SEP = System.getProperty("file.separator");

  public static String readFile(String filePath)
  {
    return readFile(new File(filePath));
  }

  public static String readFile(File file) {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      String encoding = "UTF-8";
      if ((file.isFile()) && (file.exists())) {
        InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);

        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt = null;
        while ((lineTxt = bufferedReader.readLine()) != null)
          stringBuilder.append(lineTxt);

        read.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return stringBuilder.toString();
  }

  public static void writeFile(String filepath, String content) {
    writeFile(new File(filepath), content);
  }

  public static void writeFile(File file, String content) {
    try {
      if (!(file.exists()))
        file.createNewFile();

      BufferedWriter output = new BufferedWriter(new FileWriter(file));
      output.write(content);
      output.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void append(String filepath, String content) {
    append(new File(filepath), content);
  }

  public static void append(File file, String content) {
    FileWriter fw = null;
    try {
      fw = new FileWriter(file, true);
    } catch (IOException e) {
      e.printStackTrace();
    }
    PrintWriter pw = new PrintWriter(fw);
    pw.println(content);
    pw.flush();
    try {
      fw.flush();
      pw.close();
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static boolean delete(String filepath) {
    return delete(new File(filepath));
  }

  public static boolean delete(File file) {
    if (file.exists())
      return file.delete();
    return false;
  }

  public static boolean move(String filepath, String newfilepath) {
    File file = new File(filepath);
    if (file.exists()) {
      File newfile = new File(newfilepath);
      return file.renameTo(newfile);
    }
    return false;
  }

  public static void saveObject(File file, Object obj)
  {
    if (!(file.getParentFile().exists()))
      file.getParentFile().mkdirs();

    ObjectOutputStream output1 = null;
    try {
      output1 = new ObjectOutputStream(new FileOutputStream(file));
      output1.writeObject(obj);
      output1.flush();
    } catch (Exception e) {
    }
    finally {
      try {
        output1.close();
      }
      catch (IOException localIOException2)
      {
      }
    }
  }

  public static <T> T readObject(File file, Class<T> t)
  {
    if ((file == null) || (!(file.exists())) || (file.isDirectory()))
    {
      throw new IllegalArgumentException("file " + file + " is not existed or is a directory");
    }
    try
    {
      return readObject(new FileInputStream(file), t);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public static <T> T readObject(InputStream is, Class<T> t)
  {
    ObjectInputStream inputStream = null;
    try {
      inputStream = new ObjectInputStream(is);
      Object result = inputStream.readObject();
      Object localObject1 = result;

      return (T) localObject1;
    }
    catch (Exception e)
    {
    }
    finally
    {
      try
      {
        inputStream.close();
      } catch (IOException e) {
        e.printStackTrace(); }
    }
    return null;
  }

  public static String getMimeType(String fileUrl) {
    FileNameMap fileNameMap;
    try {
      fileNameMap = URLConnection.getFileNameMap();
      String type = fileNameMap.getContentTypeFor(fileUrl);
      return type;
    } catch (Exception e) {
      logger.error("getMimeType(String fileUrl)"+fileUrl,e);
    }
    return "";
  }
  private static Logger logger = LoggerFactory.getLogger(FileUtils.class);
}