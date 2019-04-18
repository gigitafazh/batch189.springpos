package com.bootcamp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_barang")
public class Barang implements Serializable {

	@Id
	@Column(name = "kode", length = 10, nullable = false)
	private String kode;

	@Column(name = "nama", length = 100, nullable = false)
	private String nama;

	@Column(name = "harga", length = 10, nullable = false)
	private long harga;

	@Column(name = "satuan", length = 100, nullable = false)
	private String satuan;

	public String getKode() {
		return kode;
	}

	public void setKode(String kode) {
		this.kode = kode;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public long getHarga() {
		return harga;
	}

	public void setHarga(long harga) {
		this.harga = harga;
	}

	public String getSatuan() {
		return satuan;
	}

	public void setSatuan(String satuan) {
		this.satuan = satuan;
	}
}