import axios from 'axios'
import cookie from 'js-cookie'
// 创建axios实例
const service = axios.create({
    baseURL: 'http://10.128.216.179:8222', // api的base_url
    timeout: 20000 // 请求超时时间
})

//拦截器
service.interceptors.request.use(               
    config => {
        if (cookie.get('guli_token')) {
            config.headers['token'] = cookie.get('guli_token')
        }
        //console.log(config);
        return config   //config里面存啥
    },
    err => {
        return Promise.reject(err)
    }
)

export default service