<script setup>
import { RouterView, RouterLink } from 'vue-router';
import useMember2 from './stores/useMember2';

const { computedMid, signout } = useMember2();

console.log("-----------------------------");
console.log(computedMid);
</script>

<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">

    <div class="container-fluid">

      <a class="navbar-brand" href="#">TodoApp</a>

      <div class="collapse navbar-collapse">

        <ul class="navbar-nav me-auto mb-2 mb-lg-0">

          <li class="nav-item">
            <RouterLink to="/" class="nav-link">Main</RouterLink>
          </li>

          <li class="nav-item">
            <RouterLink to="/todo" class="nav-link">Todo</RouterLink>
          </li>

          <li class="nav-item">
            <RouterLink to="/mypost" class="nav-link">MyPost</RouterLink>
          </li>

        </ul>

        <ul class="navbar-nav ml-auto">

          <li v-if="computedMid === ''" class="nav-item">
            <RouterLink to="/login" class="nav-link">Login</RouterLink>
          </li>

          <li v-if="computedMid !== ''" class="nav-item">
            <button @click="signout" class="btn btn-outline-danger">Logout</button>
          </li>

        </ul>

      </div>

    </div>

  </nav>

  <div class="container mt-4">
    <div class="alert alert-info text-center">
      <hr />
      USERID : {{ computedMid }}
      <hr />
    </div>
    <RouterView></RouterView>
  </div>
</template>

<style scoped>
/* Custom styles to enhance the "lovely" aesthetic */
.navbar {
  background-color: #f8bbd0;
  /* Soft pink background */
}

.nav-link {
  font-weight: bold;
  color: #880e4f !important;
  /* Dark pink text */
}

.btn-outline-danger {
  color: #880e4f;
  border-color: #880e4f;
}

.btn-outline-danger:hover {
  background-color: #880e4f;
  color: #fff;
}

.alert-info {
  background-color: #fce4ec;
  /* Light pink background */
  border-color: #f8bbd0;
  color: #880e4f;
}

.container {
  background-color: #ffffff;
  border-radius: 15px;
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
  padding: 20px;
}

hr {
  border-top: 2px solid #f8bbd0;
}
</style>