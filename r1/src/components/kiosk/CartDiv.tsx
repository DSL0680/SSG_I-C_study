import {ICartItem} from "../../types/kiosk.ts";
import {ReactElement} from "react";

interface CartDivProps {
    cartItems: ICartItem[],
    changeQty: (pid:number, qty:number) => void
}

function CartDiv({cartItems, changeQty}: CartDivProps): ReactElement {

    console.log(cartItems)

    const listLI = cartItems.filter(item => item.qty > 0)
        .map(item => {
        const {product, qty} = item
        return (
            <li key={product.pid} className='flex flex-wrap gap-3 border-2 border-gray-200'>
                {product.img && <img className='w-1/5' src={product.img}/>}
                {product.pname} : {qty} : {product.price * qty}
                <button onClick={() => changeQty(product.pid, 1)}> + </button>
                <button onClick={() => changeQty(product.pid, -1)}> - </button>
            </li>
        )
    })

    return (
        <div>
            <ul>
                {listLI}
            </ul>
        </div>
    );
}

export default CartDiv;