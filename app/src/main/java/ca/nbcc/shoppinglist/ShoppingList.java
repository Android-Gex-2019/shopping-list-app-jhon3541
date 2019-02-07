/**
 * @file
 * @author Jhon Romero
 * @version 1.0
 *
 *
 * @section DESCRIPTION
 * Shopping List Assignment
 *
 *
 * @section LICENSE
 *
 *
 * Copyright 2019
 * Permission to use, copy, modify, and/or distribute this software for
 * any purpose with or without fee is hereby granted, provided that the
 * above copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 *
 * @section Academic Integrity
 * I certify that this work is solely my own and complies with
 * NBCC Academic Integrity Policy (policy 1111)
 */

package ca.nbcc.shoppinglist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ShoppingList implements Serializable {


    /**
     * Map that holds the item name and the quantity
     */
    private Map<String, Integer> shoppingMap = new HashMap<String, Integer>();

    /**
     * Constructor
     */
    public ShoppingList() {

    }

    /**
     * Getter
     * @return Shopping map
     */
    public Map<String, Integer> getShoppingMap() {
        return shoppingMap;
    }

    /**
     * Setter
     * @param shoppingMap
     */
    public void setShoppingMap(Map<String, Integer> shoppingMap) {
        this.shoppingMap = shoppingMap;
    }

    /**
     * Method to add item to the shopping map
     * @param item
     */
    public void addItem(String item){

        if(this.shoppingMap.containsKey(item)){

            this.shoppingMap.replace(item, (int)this.shoppingMap.get(item)+1);

        }else{

            this.shoppingMap.put(item, 1);

        }

    }

    /**
     * Method to get item count from an specific item
     * @param item
     * @return item count
     */
    public String getItemCount(String item)
    {
        String itemCount="";

        for (String key : this.shoppingMap.keySet()) {

            if(key.equalsIgnoreCase(item))
            {
                Integer value = this.shoppingMap.get(key);
                itemCount = key + "-" + value;
            }


        }

        return itemCount;

    }






}
