import request from '../utils/request'

export default{
    //查询所有
    getNewcustomer(){
        return request({
            url:`/center/ucenter-member/getNewCustomer`,
            method:'get'
        })
    },
    //授权
    assign_right(userInfo){
        return request({
            url:'/center/ucenter-member/updateCustomer?cutomer_id=' + userInfo,
            method:'post'
            })
    },
    //导出表tbatuc2-i
    dataout_tbatuc2_i(userInfo){
        return request({
            url:'/Data/tbatuc2-i/writeExecl?filename='+userInfo,
            method:'post'
        })
    },
    //导出表tbc2-i
    dataout_tboptcell_controller(userInfo){
        return request({
            url:'/Data/tboptcell/writeExecl?filename='+userInfo,
            method:'post'
        })
    },
    //导出表tbatuhandover-controller
    dataout_tbatuhandover_controller(userInfo){
        return request({
            url:'/Data/tbatuhandover/writeExecl?filename='+userInfo,
            method:'post'
        })
    },
    //导入表tbcell
    datain_tbcell(userInfo){
        return request({
            url:'/Data/tbcell/addData',
            method:'post',
            headers:{
                'Content-Type': 'multipart/form-data',
            },
            data:userInfo
        })
    },
    //导入表tbcellkpi
    datain_tbcellkpi(userInfo){
        return request({
            url:'/Data/tbcellkpi/addData',
            method:'post',
            headers:{
                'Content-Type': 'multipart/form-data',
            },
            data:userInfo
        })
    },
    //导入表tbprb
    datain_tbprb(userInfo){
        return request({
            url:'/Data/tbprb/addData',
            method:'post',
            headers:{
                'Content-Type': 'multipart/form-data',
            },
            data:userInfo
        })
    },
    login(userInfo){
        return request({
                        url: `/admin/acl/user/login`,
                        method: 'post',
                        data: userInfo
                    })
    }
}