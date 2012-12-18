package com.alienlabz.exemplo.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelData implements Parcelable {
	public static final Parcelable.Creator<ParcelData> CREATOR = new Creator<ParcelData>() {

		@Override
		public ParcelData[] newArray(int size) {
			return new ParcelData[size];
		}

		@Override
		public ParcelData createFromParcel(Parcel source) {
			return new ParcelData(source);
		}

	};
	public String nome;
	public String descricao;
	public int idade;

	public ParcelData(Parcel source) {
		nome = source.readString();
		descricao = source.readString();
		idade = source.readInt();
	}

	public ParcelData() {
	}

	@Override
	public int describeContents() {
		return hashCode();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(nome);
		dest.writeString(descricao);
		dest.writeInt(idade);
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(nome);
		s.append(" - ");
		s.append(descricao);
		s.append(" - ");
		s.append(idade);
		return s.toString();
	}
}
