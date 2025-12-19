# Cypher Tool! 🚀


#### The Cypher Tool takes your message and encrypts the message using various ciphers of your choosing.

<br>
<br>

**Key Features:**

| Feature         | Case sensitivity | Explanation|
| --------------- | :-------: |-------------------------------- |
| Rot13 cipher      |    ✅     |Rotates the message by 13 characters|
| Atbash cipher    |    ✅     |Reverses the letter from first to last|
| Caesar cipher    |    ✅     |Asks for user's shift input, rotates characters by given number|


<br>
<br>

### Rot 13 cipher

[Rot13](https://en.wikipedia.org/wiki/ROT13) rotates the letters by 13 characters, meaning:
* In case of encryption, A -> N, B -> O and so on.
* In case of decryption, N -> A, O -> B and so on.
Only latin alphabet is ciphered, rest of the characters (such as "!" or "/") remain the same. 
<br>
<br>

### Atbash cipher
[Atbash](https://en.wikipedia.org/wiki/Atbash) flips the letters from first to last, meaning:
* In case of encryption, A -> Z, B -> Y and so on.
* In case of decryption, Z -> A, Y -> B and so on.
<br>
<br>

### Caesar cipher
[Caesar](https://en.wikipedia.org/wiki/Caesar_cipher) rotates the letters by custom shift margin given by the user, meaning:
* In case of encryption with shift as 3, then A -> D, B -> E and so on.
* In case of decryption with shift as 5, F -> A, G -> B and so on.

NB! As long as the shift number for Caesar cipher is between -9,223,372,036,854,775,808 and 9,223,372,036,854,775,807, it's down to play. 

<br>
<br>
<br>

### How to run:
* ```git clone https://gitea.kood.tech/KKalvik/cypherTool.git```
* ```cd CypherTool```
* ```java CypherTool.java```
<br>
<br>

#### **⚠️ Important Note:**
If you're getting ```fatal: destination path 'cypherTool' already exists and is not an empty directory.``` then:
* (in the vscode terminal): ```mkdir review```
* ```cd review```
* ```git clone https://gitea.kood.tech/KKalvik/cypherTool.git```
* ```cd CypherTool```
* ```java CypherTool.java```

<br>