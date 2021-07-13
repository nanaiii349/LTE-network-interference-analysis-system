import request from '@/utils/request'

export default{
    searchbyName(nameinfo){
        return request({            
            url: `/Queries/tbcell/geteNodeByName?enodeName=`+nameinfo.input1+`&filename=`+nameinfo.fileway1.replace(":","%3A").replace(/\\/g,"%5C"),
            method: 'post',
            //data: nameinfo
        })
    },

    searchbyId(idinfo){
        return request({            
            url: `/Queries/tbcell/geteNodeById?enodeId=`+idinfo.input2+`&filename=`+idinfo.fileway2.replace(":","%3A").replace(/\\/g,"%5C"),
            method: 'post',
            //data: nameinfo
        })
    },
}