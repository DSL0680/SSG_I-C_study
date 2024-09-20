import ProductList from "./ProductList.tsx";
import CartDiv from "./CartDiv.tsx";
import { IProduct } from "../../types/kiosk.ts";
import useKiosk, { IUseKiosk } from "../../hooks/useKiosk.ts";
import { useState } from "react";

function KioskMain() {
    const products: IProduct[] = [
        { pid: 1, pname: 'M1', price: 3000, img: 'http://localhost:8081/food/M1.jpeg', kind: 'A' },
        { pid: 2, pname: 'M2', price: 4000, img: 'http://localhost:8081/food/M2.jpeg', kind: 'A' },
        { pid: 3, pname: 'M3', price: 5000, img: 'http://localhost:8081/food/M3.jpeg', kind: 'B' },
        { pid: 4, pname: 'M4', price: 6000, img: 'http://localhost:8081/food/M4.jpeg', kind: 'B' },
        { pid: 5, pname: 'M5', price: 7000, img: 'http://localhost:8081/food/M5.jpeg', kind: 'C' },
    ];

    const [type, setType] = useState<string>('ALL');

    const filteredList: IProduct[] = products.filter(p => {
        if (type === 'ALL') {
            return true;
        }
        return p.kind === type;
    });

    const { cartItems, addToCart, changeQty }: IUseKiosk = useKiosk();

    return (
        <div className='w-full h-full p-3 flex'>
            <div className='w-2/3 bg-amber-600 m-2 p-2'>
                <div className="mb-4">
                    <button onClick={() => setType('ALL')} className={`mr-2 ${type === 'ALL' ? 'bg-blue-300' : 'bg-gray-300'} p-2 rounded`}>
                        ALL</button>
                    <button onClick={() => setType('A')} className={`mr-2 ${type === 'A' ? 'bg-blue-300' : 'bg-gray-300'} p-2 rounded`}>
                        A</button>
                    <button onClick={() => setType('B')} className={`mr-2 ${type === 'B' ? 'bg-blue-300' : 'bg-gray-300'} p-2 rounded`}>
                        B</button>
                    <button onClick={() => setType('C')} className={`mr-2 ${type === 'C' ? 'bg-blue-300' : 'bg-gray-300'} p-2 rounded`}>
                        C</button>
                </div>

                <ProductList products={filteredList} addToCart={addToCart}></ProductList>
            </div>


            <div className='w-1/3 bg-blue-500 m-2 p-2'>
                <CartDiv cartItems={cartItems} changeQty={changeQty}></CartDiv>
            </div>
        </div>
    );
}

export default KioskMain;
