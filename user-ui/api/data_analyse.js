import request from '@/utils/request'

export default {
    //getc2i
    getc2i(userInfo){
        return request({
            url:'/Queries/tbmrodata/getC2i?servingSector='+userInfo.s_id
            +'&InterferingSector='+userInfo.i_id,
            method:'post'
        })
    },
    //getc2i_3
    getc2i_3(userInfo){
        userInfo = userInfo*0.01;
        return request({
            url:'Queries/tbc2-inew/getTbc2i3?x='+userInfo,
            method:'post'
        })
    },
    

}