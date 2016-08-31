###Read input from a text file to display primitive graphics.
####Input text file guide:
```
start picture <char>
<shape> [params...]
draw picture <char> <color> <x> <y>
dance picture <char> <x> <y>
erase
start picture <char>
...
erase
end picture
```
####Notation for `<shape> [params...]`:
```
circle <x> <y> <size>
rectangle <x> <y> <width> <height>
coloredrect <x> <y> <width> <height>
myShape <x> <y> <w> <h> <arcW> <arcH>
```

To build: 
```
git clone https://github.com/xabv/simple-gfx.git
cd simple-gfx
javac Main.java
java Main <your-file>.txt
```
