<template>
<MyNav></MyNav>
<div class="container">
    
    <MyTitle></MyTitle>

    <TodoContainer></TodoContainer>
    

</div>
</template>

<script setup>
import CountContainer from '../components/ex3/CountContainer.vue';
import Counter1 from '../components/ex1/Counter1.vue';
import Counter2 from '../components/ex1/Counter2.vue';
import Ex1 from '../components/ex1/Ex1.vue';
import InputEx from '../components/ex2/InputEx.vue';
import MyContent from '../components/MyContent.vue';
import MyFooter from '../components/MyFooter.vue';
import MyNav from '../components/MyNav.vue';
import MyTitle from '../components/MyTitle.vue';
import SelectEx from '../components/ex2/SelectEx.vue';
import SelectEx2 from '../components/ex2/SelectEx2.vue';
import TodoContainer from '../components/ex4/TodoContainer.vue';

const mails = [
    {mno:1, title:'AAAAA'},
    {mno:2, title:'BAAAA'},
    {mno:3, title:'CAAAA'},
    {mno:4, title:'DAAAA'},
    {mno:5, title:'EAAAA'},
]

const doA = () => {
    console.log('doA')
}

</script>

<style lang="scss" scoped>

</style>