import request from '@/utils/request'

export default{
    searchkpi(info){
        return request({            
            url: `/Queries/tbcellkpi/getKpi?sectorName=`+info.input1+`&start=`+info.start+`&end=`+info.end+`&filename=`+info.fileway1.replace(":","%3A").replace(/\\/g,"%5C"),
            method: 'post',
            //data: nameinfo
        })
    },
}