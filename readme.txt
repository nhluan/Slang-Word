class: Handle
    function:
    + readFile => return dictionary
    + printDefinition => nhan vao mot arraylist => in ra cac item
    + writeFile => no return

class: dictionary
    function:
    + printDict() => in tat cac cac slang word kem theo definition
    + printHistory() => in tat ca cac tu slang word user da tim
    + findBySlang(String key) => return string (definition of slang word)
    + findByDefinition(String key) => return string (slang word of definition)
    + checkSlang(String) => kiem tra co trung slang trong dict co san hay khong
    + addSlang(String, String) => them slang va definition vao dictionary
    + editSlang(String, String) => chi cho phep chinh sua definition, khong duoc chinh slang
    + getDict() => return hashmap<String, String>
    + randomMinMax(int)
    + randSlang() => return arraylist


Trash:
 ArrayList<String> result = new ArrayList<String>(); // luu ket qua tra ve
        ArrayList<Integer> store = new ArrayList<Integer>(); // luu cac vi tri can lay value de lam dap an
        ArrayList<Integer> added = new ArrayList<Integer>(); // luu cac vi tri da duoc add vao result
        ArrayList<Integer> addedResult = new ArrayList<Integer>();

        ArrayList<String> add = this.randomSlang(); //key and value root (true)

        result.add(add.get(0)); //slang word

        int count = 1; //3 dung
        store.add(randomMinMax(0, dict.size()));

        while (true) {
            if (count == 3) {
                break;
            }

            int number = randomMinMax(0, dict.size());

            if (checkExist(store, number) == 0) {
                count++;
                store.add(number);
            }
        }

        count = 0;
        String ans = this.getSlang(store.get(0)).get(1);
        result.add(ans);

        addedResult.add(0);
        addedResult.add(1);
        //con 2 3 4 dang can tim
        // => min 2 max 4

        while (true) {
            if (count == 3) {
                break;
            }

            int pos = this.randomMinMax(2, 4);

            if (checkExist(addedResult, pos) == 0) {
                //lay value add vo
                result.add(this.getSlang(store.get(count)).get(1));
                addedResult.add(pos);
                count++;
            }
        }

//        result.add(add.get(1));
