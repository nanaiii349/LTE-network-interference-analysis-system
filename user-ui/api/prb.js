import request from '@/utils/request'

export default{
    searchenodeb(info){
        return request({            
            url: `/Queries/tbprb/getENode?ENode=`+info.ENode+`&t=`+info.t+`&start=`+info.start.replace(":","%3A").replace(":","%3A")+`&end=`+info.end.replace(":","%3A").replace(":","%3A")+`&filename=`+info.filename.replace(":","%3A").replace(/\\/g,"%5C"),
            method: 'post',
            //data: nameinfo
        })
    },
    generate(filepath){
        return request({
            url:`/Queries/tbprb/getKpi?filename=`+filepath.replace(":","%3A").replace(/\\/g,"%5C"),
            method:'post'
        })
    }
}