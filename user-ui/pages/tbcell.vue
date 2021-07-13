<template>
    <div>
        <div class="in" style="text-align:center">
            <el-input v-model="Nameinfo.input1" placeholder="小区名称" style="width:400px;height:80px">
            </el-input>
            <el-input v-model="Nameinfo.fileway1" placeholder="文件路径" style="width:400px;height:80px" type="text">
            </el-input>
            <el-button @click="submitName" style="width:70px;height:40px">查询</el-button>
        </div>      
        <div class="in2" style="text-align:center">
            <el-input v-model="Idinfo.input2" placeholder="小区ID" style="width:400px;height:80px">
            </el-input>
            <el-input v-model="Idinfo.fileway2" placeholder="文件路径" style="width:400px;height:80px">
            </el-input>
            <el-button @click="submitId" style="width:70px;height:40px">查询</el-button>
        </div>
        <div class="show">
            <el-table
                :data="tableData"
                style="width: 100%">
                <el-table-column type="expand">
                    <template slot-scope="props">
                        <el-form label-position="left" inline class="demo-table-expand">
                        <el-form-item label="CITY:">
                            <span>{{ props.row.city }}</span>
                        </el-form-item>
                        <el-form-item label="SECTOR_ID:">
                            <span>{{ props.row.sectorId }}</span>
                        </el-form-item>
                        <el-form-item label="SECTOR_NAME:">
                            <span>{{ props.row.sectorName }}</span>
                        </el-form-item>
                        <el-form-item label="ENODEBID:">
                            <span>{{ props.row.enodebid }}</span>
                        </el-form-item>
                        <el-form-item label="ENODEBNAME:">
                            <span>{{ props.row.enodebName }}</span>
                        </el-form-item>
                        <el-form-item label="EARFCN:">
                            <span>{{ props.row.earfcn }}</span>
                        </el-form-item>
                        <el-form-item label="PCI:">
                            <span>{{ props.row.pci }}</span>
                        </el-form-item>
                        <el-form-item label="PSS:">
                            <span>{{props.row.pss}}</span>
                        </el-form-item>
                        <el-form-item label="SSS:">
                            <span>{{props.row.sss}}</span>
                        </el-form-item>
                        <el-form-item label="TAC:">
                            <span>{{props.row.tac}}</span>
                        </el-form-item>
                        <el-form-item label="VENDOR:">
                            <span>{{props.row.vendor}}</span>
                        </el-form-item>
                        <el-form-item label="LONGITUDE:">
                            <span>{{props.row.longitude}}</span>
                        </el-form-item>
                        <el-form-item label="LATITUDE:">
                            <span>{{props.row.latitude}}</span>
                        </el-form-item>
                        <el-form-item label="STYLE:">
                            <span>{{props.row.style}}</span>
                        </el-form-item>
                        <el-form-item label="AZIMUTH:">
                            <span>{{props.row.azimuth}}</span>
                        </el-form-item>
                        <el-form-item label="HEIGHT:">
                            <span>{{props.row.height}}</span>
                        </el-form-item>
                        <el-form-item label="ELECTTIL:">
                            <span>{{props.row.electtilt}}</span>
                        </el-form-item>
                        <el-form-item label="MECHTILE:">
                            <span>{{props.row.mechtilt}}</span>
                        </el-form-item>
                        <el-form-item label="TOTLETILE:">
                            <span>{{props.row.totletilt}}</span>
                        </el-form-item>
                        </el-form>
                    </template>
                </el-table-column>
                <el-table-column
                    label="CITY"
                    prop="city">
                </el-table-column>
                <el-table-column
                    label="小区名称"
                    prop="sectorName">
                </el-table-column>
                <el-table-column
                    label="小区ID"
                    prop="sectorId">
                </el-table-column>
                <el-table-column
                    label="基站名称"
                    prop="enodebName">
                </el-table-column>
                <el-table-column
                    label="基站ID"
                    prop="enodebid">
                </el-table-column>
            </el-table>
        </div>
    </div>
</template>

<script>
import searchApi from '@/api/tbcell'
export default {
    data() 
    {
        return {
          tableData: [],
          Nameinfo:{
            input1:'',
            fileway1:'',
          },
          Idinfo:{
            input2:'',
            fileway2:''
          },
          
        }
    },
    methods:{
        submitName(){           
            searchApi.searchbyName(this.Nameinfo)
                .then(response=>{
                    console.log(response)
                    this.tableData=response.data.data.rows
                })    
        },
        submitId(){
            searchApi.searchbyId(this.Idinfo)
                .then(response=>{
                    console.log(response)
                    this.tableData=response.data.data.rows
                })
        }
    }
}
</script>

