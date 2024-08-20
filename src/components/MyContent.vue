<template>
    <div class="row g-3">
        <div class="col-md-6 col-lg-4 col-xl-3" v-for="({ pno, pname, price, sale }) in saleProducts" :key="pno">
            <h2>{{ pname }}</h2>
            <p>{{ price }}HTML is the standard markup language for describing the structure of the web pages. Our HTML
                tutorials will help you to understand the basics of latest HTML5 language, so that you can create your
                own website.</p>
            <p><a href="https://www.tutorialrepublic.com/html-tutorial/" target="_blank" class="btn btn-success">Learn
                    More &raquo;</a></p>
        </div>
    </div>
</template>

<script setup>
import { computed, ref } from 'vue';


const arr = ref( [
    { pno: 1, pname: 'P1', price: 3000, sale: true },
    { pno: 2, pname: 'P2', price: 4000, sale: false },
    { pno: 3, pname: 'P3', price: 5000, sale: true },
    { pno: 4, pname: 'P4', price: 6000, sale: false },
]
)

const saleProducts = computed( () => arr.value.filter(p => p.sale === true) )

setTimeout( () => {
    console.log("setTimeout........")
    arr.value.push({ pno: 5, pname: 'P5', price: 7000, sale: true })
    arr.value.push({ pno: 6, pname: 'P6', price: 8000, sale: true })
}, 3000)

</script>

<style lang="scss" scoped></style>