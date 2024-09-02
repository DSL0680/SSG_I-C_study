
<template>
    <TodoBox :title="'Todo List'">
      <button @click="handleClickRemove">REMOVE</button>
      <ul>
        <li v-for="todo in props.todoList" :key="todo.tno">
          <input type="checkbox" :value="todo.tno" v-model="selectList" >
          <TodoItem :todo="todo" 
            @deleteTodo="(param) => emits('removeTodos',param)" 
            @modifyTodo="(param) => emits('modifyTodo', param)"
            ></TodoItem>
        </li>
      </ul>
    </TodoBox>
  </template>
  
  <script setup>
  import { ref } from 'vue';
  import TodoBox from './TodoBox.vue';
  import TodoItem from './TodoItem.vue';
  
  const props = defineProps(['todoList'])
  const emits = defineEmits(['removeTodos','modifyTodo'])
  const selectList = ref([])
  
  const handleClickRemove = ()=> {
    console.log(selectList.value)
    if(selectList.value.length == 0){
      return
    }
    emits('removeTodos',selectList.value)
  }
  
  </script>
  
  <style  scoped>
  li{
    list-style: none;
  }
  
  </style>