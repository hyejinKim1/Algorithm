function solution(word){
    let ans = 0;
    let alpha = ["A", "E", "I", "O", "U"];
    let cnt = 0;
    let flag = false;

    const dfs = (str) => {
        if(str.length>5) return;

        if(str === word){
            ans = cnt;
            flag = true;
            return;
        }

        cnt += 1;

        for(let i=0; i<5; i++){
            dfs(str+alpha[i]);
        }
    };
    dfs("");

    return ans;
}