<template>
    <img :src="backImg" style="width:1200px;height:1000px" />
</template>

<script>
import backImg from "../assets/img/1.png";
 
export default 
{
  data() {
    return {
    backImg: backImg,
    };
  },
}

</script>