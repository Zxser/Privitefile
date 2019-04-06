<!--
	时间：2017-05-02
	描述：分页组件
-->
<template>
    <!--分页组件-->
    <div class="Paging">
        <!--分页-->
        <el-col :span="24" class="toolbar" style="padding-bottom:10px;">
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="pageInfo.pageNum"
                    :page-size="pageInfo.pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="pageInfo.totalCount"
                    style="float:right"
            >
            </el-pagination>
        </el-col>
    </div>
</template>

<script>
    export default {
        name: 'Paging',
        data () {
            return {}
        },
        props:{
            pageInfo:{
                type:Object
            }
        },
        methods:{
            //分页
            handleSizeChange(val) {
                this.pageInfo.pageSize = val;
                this.$emit('monitorPaging')
            },
            handleCurrentChange(val) {
                this.pageInfo.pageNum = val;
                this.$emit('monitorPaging')
            },
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
