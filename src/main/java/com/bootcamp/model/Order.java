package com.bootcamp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "t_order")
public class Order implements Serializable {

	@Id
	@Column(name = "kode", length = 10, nullable = false)
	private String kode;

	@Column(name = "nama_pelanggan", length = 10, nullable = false)
	private String namaPelanggan;

	@Column(name = "tgl_transaksi")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Jakarta")
	private Date tglTransaksi;

	@Column(name = "grand_total")
	private long grandTotal;

	public String getKode() {
		return kode;
	}

	public void setKode(String kode) {
		this.kode = kode;
	}

	public String getNamaPelanggan() {
		return namaPelanggan;
	}

	public void setNamaPelanggan(String namaPelanggan) {
		this.namaPelanggan = namaPelanggan;
	}

	public Date getTglTransaksi() {
		return tglTransaksi;
	}

	public void setTglTransaksi(Date tglTransaksi) {
		this.tglTransaksi = tglTransaksi;
	}

	public long getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(long grandTotal) {
		this.grandTotal = grandTotal;
	}
}