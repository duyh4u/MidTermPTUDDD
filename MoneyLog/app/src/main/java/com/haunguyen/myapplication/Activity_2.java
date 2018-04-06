package com.haunguyen.myapplication;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Hau Nguyen on 02-Apr-18.
 */

public class Activity_2 extends Activity {
    ArrayList<ThongTinThuChi> arr;

    Button btnThem;
    Button btnNhapLai;
    Button btnHienThi;
    EditText edtNoiDung;
    EditText edtSoTien;
    RadioGroup rbtnGroup;
    RadioButton rbtnThu;
    RadioButton rbtnChi;

    TextView tvDate;
    Button btnChonNgay;

    Calendar cal;
    Date date;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        arr=new ArrayList<>();

        btnThem = (Button) findViewById(R.id.btnThem);
        btnNhapLai = (Button) findViewById(R.id.btnNhaplai);
        btnHienThi = (Button) findViewById(R.id.btnHienthi);
        edtNoiDung = (EditText) findViewById(R.id.edtNoidung);
        edtSoTien = (EditText) findViewById(R.id.edtSotien);
        rbtnThu = (RadioButton) findViewById(R.id.rbtnThu);
        rbtnChi = (RadioButton) findViewById(R.id.rbtnChi);
        rbtnGroup = (RadioGroup) findViewById(R.id.rbtnGroup);
        btnChonNgay = (Button) findViewById(R.id.btnChonNgay);
        tvDate = (TextView) findViewById(R.id.tvDate);

        showDefaultDate();

        btnChonNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chonNgay();
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Them();
            }
        });

        btnNhapLai.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                edtNoiDung.setText("");
                edtSoTien.setText("");
                edtNoiDung.requestFocus();
            }
        });

        btnHienThi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.putExtra("data", arr);
                setResult(RESULT_OK, intent);
                finish();

            }
        });

    }

    private void showDefaultDate() {
        cal  =Calendar.getInstance();
        SimpleDateFormat dft = null;
        dft = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String strDate = dft.format(cal.getTime());
        tvDate.setText(strDate);
    }

    private void chonNgay() {
        DatePickerDialog.OnDateSetListener callback =
                new DatePickerDialog.OnDateSetListener() {
                    //Sự kiện khi click vào nút Done trên Dialog
                    @Override
                    public void onDateSet(DatePicker datePicker,
                                          int year,
                                          int month,
                                          int day) {
                        tvDate.setText(day + "/" + (month +1) + "/" + year);
                        cal.set(year, month, day);
                        date = cal.getTime();
                    }
                };

        String s = tvDate.getText()+"";
        String strArrtmp[] = s.split("/");
        int ngay = Integer.parseInt(strArrtmp[0]);
        int thang = Integer.parseInt(strArrtmp[1]) - 1;
        int nam = Integer.parseInt(strArrtmp[2]);
        DatePickerDialog pic = new DatePickerDialog(
                Activity_2.this,
                callback, nam, thang, ngay);
        pic.show();
    }

    public void Them(){
            String noidung = edtNoiDung.getText()+"";
            String sotien = edtSoTien.getText()+"";
            String ngay = tvDate.getText()+"";
            boolean hinhthuc = false;
            if(rbtnGroup.getCheckedRadioButtonId()== R.id.rbtnThu) {
                hinhthuc = true;
            }
            ThongTinThuChi thongTinThuChi = new ThongTinThuChi();
            thongTinThuChi.setNoidung(noidung);
            thongTinThuChi.setSotien(sotien);
            thongTinThuChi.setHinhthuc(hinhthuc);
            thongTinThuChi.setDate(ngay);
            arr.add(thongTinThuChi);
        }

    }
