package com.dh.taiyi.common;

import java.io.UnsupportedEncodingException;

/**
 * ת���ַ����ı���
 */
public class ChangeCharset {
	/** 7λASCII�ַ���Ҳ����ISO646-US��Unicode�ַ����Ļ��������� */
	public static final String US_ASCII = "US-ASCII";

	/** ISO ������ĸ�� No.1��Ҳ���� ISO-LATIN-1 */
	public static final String ISO_8859_1 = "ISO-8859-1";

	/** 8 λ UCS ת����ʽ */
	public static final String UTF_8 = "UTF-8";

	/** 16 λ UCS ת����ʽ��Big Endian����͵�ַ��Ÿ�λ�ֽڣ��ֽ�˳�� */
	public static final String UTF_16BE = "UTF-16BE";

	/** 16 λ UCS ת����ʽ��Little-endian����ߵ�ַ��ŵ�λ�ֽڣ��ֽ�˳�� */
	public static final String UTF_16LE = "UTF-16LE";

	/** 16 λ UCS ת����ʽ���ֽ�˳���ɿ�ѡ���ֽ�˳��������ʶ */
	public static final String UTF_16 = "UTF-16";

	/** ���ĳ����ַ��� */
	public static final String GBK = "GBK";

	/**
	 * ���ַ�����ת����US-ASCII��
	 */
	public String toASCII(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, US_ASCII);
	}

	/**
	 * ���ַ�����ת����ISO-8859-1��
	 */
	public String toISO_8859_1(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, ISO_8859_1);
	}

	/**
	 * ���ַ�����ת����UTF-8��
	 */
	public String toUTF_8(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, UTF_8);
	}

	/**
	 * ���ַ�����ת����UTF-16BE��
	 */
	public String toUTF_16BE(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, UTF_16BE);
	}

	/**
	 * ���ַ�����ת����UTF-16LE��
	 */
	public String toUTF_16LE(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, UTF_16LE);
	}

	/**
	 * ���ַ�����ת����UTF-16��
	 */
	public String toUTF_16(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, UTF_16);
	}

	/**
	 * ���ַ�����ת����GBK��
	 */
	public String toGBK(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, GBK);
	}

	/**
	 * �ַ�������ת����ʵ�ַ���
	 * 
	 * @param str
	 *            ��ת��������ַ���
	 * @param newCharset
	 *            Ŀ�����
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String changeCharset(String str, String newCharset)
			throws UnsupportedEncodingException {
		if (str != null) {
			// ��Ĭ���ַ���������ַ�����
			byte[] bs = str.getBytes();
			// ���µ��ַ����������ַ���
			return new String(bs, newCharset);
		}
		return null;
	}

	/**
	 * �ַ�������ת����ʵ�ַ���
	 * 
	 * @param str
	 *            ��ת��������ַ���
	 * @param oldCharset
	 *            ԭ����
	 * @param newCharset
	 *            Ŀ�����
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String changeCharset(String str, String oldCharset, String newCharset)
			throws UnsupportedEncodingException {
		if (str != null) {
			// �þɵ��ַ���������ַ�����������ܻ�����쳣��
			byte[] bs = str.getBytes(oldCharset);
			// ���µ��ַ����������ַ���
			return new String(bs, newCharset);
		}
		return null;
	}
}