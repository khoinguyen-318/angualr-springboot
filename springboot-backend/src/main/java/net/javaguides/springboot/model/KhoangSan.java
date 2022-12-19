package net.javaguides.springboot.model;

import javax.persistence.*;

@Entity
@Table
public class KhoangSan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long maKs;
	
	private String tenKhoangSan;

	private String tenMoKs;
	
	private String truLuong;
	private String diaChiMoKs;

	public KhoangSan() {
	}

	public KhoangSan(String tenKhoangSan, String tenMoKs, String truLuong, String diaChiMoKs) {
		this.tenKhoangSan = tenKhoangSan;
		this.tenMoKs = tenMoKs;
		this.truLuong = truLuong;
		this.diaChiMoKs = diaChiMoKs;
	}

	public long getMaKs() {
		return maKs;
	}

	public void setMaKs(long maKs) {
		this.maKs = maKs;
	}

	public String getTenKhoangSan() {
		return tenKhoangSan;
	}

	public void setTenKhoangSan(String tenKhoangSan) {
		this.tenKhoangSan = tenKhoangSan;
	}

	public String getTenMoKs() {
		return tenMoKs;
	}

	public void setTenMoKs(String tenMoKs) {
		this.tenMoKs = tenMoKs;
	}

	public String getTruLuong() {
		return truLuong;
	}

	public void setTruLuong(String truLuong) {
		this.truLuong = truLuong;
	}

	public String getDiaChiMoKs() {
		return diaChiMoKs;
	}

	public void setDiaChiMoKs(String diaChiMoKs) {
		this.diaChiMoKs = diaChiMoKs;
	}
}
