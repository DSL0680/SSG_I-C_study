<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2024-09-03(화)
  Time: 오후 1:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.jsp"%>

<div class="card shadow mb-4">
    <div class="card-body">
        <ul class="replyUL">
            <li></li>
        </ul>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

<script>

    const replyUL = document.querySelector(".replyUL")

    const getList = async (page) => {
        const res = await axios.get(
            '/reply/list/23',
            {params: {page: page || 1}})
        // console.log(res)
        return res.data
    }



    const printReply = (page) => {

        getList(page).then(data => {
            const {list, endPage} = data

            if((page || 1) < endPage){

                printReply(endPage)
                return

            }

            let str = ''

            for(const replyObj of list) {
                const {rno, reply, replyer, reg, mod} = replyObj

                str += `<li>\${rno} ----- \${reply}</li>`
            }
            console.log(str)

            replyUL.innerHTML = str

        })
    }

    printReply(1)


</script>

<%@include file="../includes/footer.jsp"%>
