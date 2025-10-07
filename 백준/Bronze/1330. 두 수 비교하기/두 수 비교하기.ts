import * as fs from "fs";

const numbers = fs.readFileSync("/dev/stdin").toString().trim().split(" ").map(Number);

if (numbers[0] < numbers[1]) console.log("<");
else if (numbers[0] > numbers[1]) console.log(">");
else console.log("==");