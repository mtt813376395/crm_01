package com.test.web.commons;

import java.io.Serializable;
import java.util.List;

import com.test.domain.Customer;

/**
 * ���ڷ�װ��ҳ���ݵĶ���
 * 
 * @author admin
 *
 */
public class Page implements Serializable {
	private int currentPageNum; // ��ǰҳ
	private int pageSize = 5; // ÿҳ��ʾ������
	private int totalRecords; // �ܼ�¼����
	private int startIndex; // ��ѯ�Ŀ�ʼ��¼����
	private int totalPageNum; // ��ҳ��
	private int prePageNum; // ��һҳ
	private int nextPageNum; // ��һҳ
	private List<Customer> records; // �ֺ�ҳ�Ľ����

	// ������ʾҳ�������
	private int beginPageNum;
	private int endPageNum;

	/**
	 * Ҫ��ʹ�ô��࣬�����ṩ2������
	 * 
	 * @param currentPageNum
	 * @param totalRecords
	 */
	public Page(int currentPageNum, int totalRecords) {
		this.currentPageNum = currentPageNum;
		this.totalRecords = totalRecords;

		// ���㿪ʼ��¼����
		startIndex = (currentPageNum - 1) * pageSize;

		// ������ҳ��
		totalPageNum = totalRecords % pageSize == 0 ? totalRecords / pageSize : totalRecords / pageSize + 1;

		// ����ҳ��
		if (totalPageNum < 9) {
			beginPageNum = 1;
			endPageNum = totalPageNum;
		} else {
			beginPageNum = currentPageNum - 4;
			endPageNum = currentPageNum + 4;
			if (beginPageNum < 1) {
				beginPageNum = 1;
				endPageNum = beginPageNum + 8;
			}
			if (endPageNum > totalPageNum) {
				endPageNum = totalPageNum;
				beginPageNum = endPageNum - 8;
			}
		}

	}

	public int getPrePageNum() {
		// ������һҳ
		prePageNum = currentPageNum - 1;
		if (prePageNum < 1) {
			prePageNum = 1;
		}
		return prePageNum;
	}

	public int getNextPageNum() {
		// ������һҳ
		nextPageNum = currentPageNum + 1;
		if (nextPageNum > totalPageNum) {
			nextPageNum = totalPageNum;
		}
		return nextPageNum;
	}

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public List<Customer> getRecords() {
		return records;
	}

	public void setRecords(List<Customer> records) {
		this.records = records;
	}

	public void setPrePageNum(int prePageNum) {
		this.prePageNum = prePageNum;
	}

	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}

	public int getBeginPageNum() {
		return beginPageNum;
	}

	public void setBeginPageNum(int beginPageNum) {
		this.beginPageNum = beginPageNum;
	}

	public int getEndPageNum() {
		return endPageNum;
	}

	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}

}
