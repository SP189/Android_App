package com.example.girishpatel.smartlearning

class Students(val id: String,val subjectName:String,val batchName:String,val profEmail:String,val profName:String,val date:String,val time:String)
{
    constructor() : this ("", "", "", "", "", "", "")
    {

    }
}