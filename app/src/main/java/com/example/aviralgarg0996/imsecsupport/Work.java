package com.example.aviralgarg0996.imsecsupport;

import android.widget.Button;

/**
 * Created by aviralgarg0996 on 20/04/17.
 */

public class Work {
   private String workTit;
   private String workDesc;
   private  String Date;



    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {this.Date = Date;}
    public void setWorkTit(String workTit) {this.workTit = workTit;}

    public void setWorkDesc(String workDesc) {
        this.workDesc = workDesc;
    }

    public String getWorkDesc() {
        return workDesc;
    }

    public String getWorkTit() {
        return workTit;
    }

    public Work(){
    }
    public Work(String work_Tit, String work_Desc,String AssignDate,String submitDate,int Flag) {
        workTit = work_Tit;
        workDesc = work_Desc;
        Date=AssignDate;
    }

}
