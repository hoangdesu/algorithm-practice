// NOT CORRECT
function longestCommonPrefix(strs: string[]): string {
    let s = '';
    let i = 0;
    while (i < strs[0].length) {
        let allEqual = true;
        let currentChar = strs[0][i];
        for (let j = 1; j < strs.length; j++) {
            console.log('strs[j]', strs[j]);
            if (strs[j] !== currentChar) {
                allEqual = false;
                break;
            }
        }
        if (allEqual) s += currentChar;
        else {
            console.log(s);
            console.log(currentChar);
            
            
        }
        i++;
    }
    return s;
}


const strs1 = ["flower","flow","flight"];
console.log(longestCommonPrefix(strs1));

const strs2 = ["dog","racecar","car"];
console.log(longestCommonPrefix(strs2));