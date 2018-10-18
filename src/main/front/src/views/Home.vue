<template>
  <div class="home">
    <div class="page">
      <div class="page-content padding-30 container-fluid">
        <div class="row">
          <h1 class="text-success">{{mesage}}</h1>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: 'home',
    mounted() {

    },
    data() {
        return {
            mesage: ' This is an home page -- '
        }
    }
}
</script>