package org.whut.mc.server.core.util;

import org.json.*;
import org.whut.mc.server.core.communication.CodecBase;
import org.whut.mc.server.core.config.PropConfig;

import java.io.UnsupportedEncodingException;

public class RealtimeMonitor extends CodecBase {

	public String resolve(byte[] data) throws UnsupportedEncodingException {
		String json = "";
		json += "{";
		String str_app = CodecUtil.getByteStr(data, 0);
		json += "\"app\":\"" + str_app + "\",";
		String str_command = CodecUtil.getByteStr(data, 1);
		json += "command" + ":\"" + str_command + "\"";
		json += "\"sensors\":{";
		byte[] bt_sensorNum = CodecUtil.sub(data, 2, 2 + 13);
		String str_sensorNum = CodecUtil.bytes2String(bt_sensorNum);
		json += "\"sensorNum\":\"" + str_sensorNum + "\",";
		String str_dataType = CodecUtil.getByteStr(data, 15);
		json += "\"dataType\":\"" + str_dataType + "\",";
		String str_time = CodecUtil.getByteStr(data, 16);
		json += "\"time\":\"" + str_time + "\",";
		String str_data = CodecUtil.getByteStr(data, 17);
		json += "data" + ":\"" + str_data + "\"";
		json += "}}";
		return json;
	}
	public byte[] code(JSONObject jsonObject) throws UnsupportedEncodingException {
		byte[] bt = new byte[0];
		String str_app = jsonObject.getString("app");
		byte byte_app = Byte.parseByte(str_app);
		byte[] bytes_app = {byte_app};
		bt = CodecUtil.merge(bt, bytes_app);
		String str_command = jsonObject.getString("command");
		byte byte_command = Byte.parseByte(str_command);
		byte[] bytes_command = {byte_command};
		bt = CodecUtil.merge(bt, bytes_command);
		String str_sensorNum = jsonObject.getString("sensorNum");
		byte[] bytes_sensorNum = CodecUtil.stringNum2Bytes(str_sensorNum, 0, str_sensorNum.length());
		bt = CodecUtil.merge(bt, bytes_sensorNum);
		String str_dataType = jsonObject.getString("dataType");
		byte byte_dataType = Byte.parseByte(str_dataType);
		byte[] bytes_dataType = {byte_dataType};
		bt = CodecUtil.merge(bt, bytes_dataType);
		String str_time = jsonObject.getString("time");
		byte byte_time = Byte.parseByte(str_time);
		byte[] bytes_time = {byte_time};
		bt = CodecUtil.merge(bt, bytes_time);
		String str_data = jsonObject.getString("data");
		byte byte_data = Byte.parseByte(str_data);
		byte[] bytes_data = {byte_data};
		bt = CodecUtil.merge(bt, bytes_data);
		PropConfig.getPropConfig().get("group.appA.tenancyA");
		PropConfig.getPropConfig().get("group.appB.tenancyA");
		return bt;
	}
}
