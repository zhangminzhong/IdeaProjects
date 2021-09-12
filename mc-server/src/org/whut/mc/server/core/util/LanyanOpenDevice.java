package org.whut.mc.server.core.util;

import org.json.*;
import org.whut.mc.server.core.communication.Codec;
import org.whut.mc.server.core.communication.CodecBase;
import java.io.UnsupportedEncodingException;

public class LanyanOpenDevice extends CodecBase {

	public String resolve(byte[] data) throws UnsupportedEncodingException {
		String json = "";
		json += "{";
		String str_begin = CodecUtil.getByteStr(data, 0);
		json += "\"begin\":\"" + str_begin + "\",";
		String str_cmd = CodecUtil.getByteStr(data, 1);
		json += "\"cmd\":\"" + str_cmd + "\",";
		String str_len = CodecUtil.getByteStr(data, 2);
		json += "\"len\":\"" + str_len + "\",";
		byte[] bt_bbh = CodecUtil.sub(data, 3, 3 + 13);
		String str_bbh = CodecUtil.bytes2String(bt_bbh);
		json += "\"bbh\":\"" + str_bbh + "\",";
		String str_frmId = CodecUtil.getByteStr(data, 16);
		json += "\"frmId\":\"" + str_frmId + "\",";
		String str_cs = CodecUtil.getByteStr(data, 17);
		json += "\"cs\":\"" + str_cs + "\",";
		String str_end = CodecUtil.getByteStr(data, 18);
		json += "end" + ":\"" + str_end + "\"";
		json += "}";
		return json;
	}
	public byte[] code(JSONObject jsonObject) throws UnsupportedEncodingException {
		byte[] bt = new byte[0];
		String str_begin = jsonObject.getString("begin");
		byte byte_begin = Byte.parseByte(str_begin);
		byte[] bytes_begin = {byte_begin};
		bt = CodecUtil.merge(bt, bytes_begin);
		String str_cmd = jsonObject.getString("cmd");
		byte byte_cmd = Byte.parseByte(str_cmd);
		byte[] bytes_cmd = {byte_cmd};
		bt = CodecUtil.merge(bt, bytes_cmd);
		String str_len = jsonObject.getString("len");
		byte byte_len = Byte.parseByte(str_len);
		byte[] bytes_len = {byte_len};
		bt = CodecUtil.merge(bt, bytes_len);
		String str_bbh = jsonObject.getString("bbh");
		byte[] bytes_bbh = CodecUtil.stringNum2Bytes(str_bbh, 0, str_bbh.length());
		bt = CodecUtil.merge(bt, bytes_bbh);
		String str_frmId = jsonObject.getString("frmId");
		byte byte_frmId = Byte.parseByte(str_frmId);
		byte[] bytes_frmId = {byte_frmId};
		bt = CodecUtil.merge(bt, bytes_frmId);
		String str_cs = jsonObject.getString("cs");
		byte byte_cs = Byte.parseByte(str_cs);
		byte[] bytes_cs = {byte_cs};
		bt = CodecUtil.merge(bt, bytes_cs);
		String str_end = jsonObject.getString("end");
		byte byte_end = Byte.parseByte(str_end);
		byte[] bytes_end = {byte_end};
		bt = CodecUtil.merge(bt, bytes_end);
		return bt;
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		Codec codec = new LanyanOpenDevice();
		byte[] in = Frame.LANYAN_OPEN;
		System.out.println("resolve input:");
		CodecUtil.showMsg(in);
		System.out.println("resolve output:");
		String json = codec.resolve(in);
		System.out.println(json);
		System.out.println("code input:");
		System.out.println(json);
		System.out.println("code output:");
		byte[] out = codec.code(new JSONObject(json));
		CodecUtil.showMsg(out);
	}
}
