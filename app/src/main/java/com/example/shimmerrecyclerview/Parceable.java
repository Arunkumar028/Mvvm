package com.example.shimmerrecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

public class Parceable implements Parcelable {

    String name;
    String age;
    String address;

    public Parceable(String name, String age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    protected Parceable(Parcel in) {
        name = in.readString();
        age = in.readString();
        address = in.readString();
    }

    public static final Creator<Parceable> CREATOR = new Creator<Parceable>() {
        @Override
        public Parceable createFromParcel(Parcel in) {
            return new Parceable(in);
        }

        @Override
        public Parceable[] newArray(int size) {
            return new Parceable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(age);
        parcel.writeString(address);
    }
}
