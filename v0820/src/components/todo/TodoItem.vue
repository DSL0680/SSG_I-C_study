<template>
    <div :class="['box', todoObj.complete ? 'end' : '']">
      <div class="lineDiv">
        <label>TNO</label>
        <div>{{ todo.tno }}</div>
      </div>
      <div class="lineDiv">
        <label>TITLE</label>
        <input type="text" v-model="todoObj.title">
      </div>
      <div class="lineDiv">
        <label>CONTENT</label>
        <input type="text" v-model="todoObj.content">
      </div>
      <div class="lineDiv">
        <div>
          <input type='checkbox' 
          :value=todoObj.tno
          v-model="todoObj.complete"
           @change="handleChangeComplete">
           {{ todoObj.complete?'END':'NOT YET' }}
        </div>
      </div>
      <div class="lineDiv">
        <button @click="handleClickDelete">DELETE</button>
        <button @click="handleClickModify">Modify</button>
      </div>
    </div>
  </template>
  
  <script setup>
  import { computed, ref, toRef } from 'vue';
  
  
  const props = defineProps(['todo'])
  const emits = defineEmits(['deleteTodo','modifyTodo'])
  
  const todoObj = ref(props.todo)
  
  const handleClickDelete = () => {
    console.log('delete', props.todo.tno)
    emits('deleteTodo',[props.todo.tno])
  }
  
  const handleClickModify = () => {
    console.log('modify', props.todo.tno)
    emits('modifyTodo', todoObj.value)
  }
  
  const handleChangeComplete = () => {
  
    console.log(todoObj.value)
    emits('modifyTodo', todoObj.value)
  }
  
  
  
  </script>
  
  <style scoped>
  
  .box {
    margin: 0.2em;
    background-color: deeppink;
  }
  
  .lineDiv {
    border-bottom: 1px solid blue;
  }
  
  .end {
    background-color: gray;
  }
  
  </style>