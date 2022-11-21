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