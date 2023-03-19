import { formatDate } from "../helpers/helpers";
import { Octokit } from "@octokit/rest";
import dotenv from "dotenv";

dotenv.config();

const endpoint = "/repos/kryptokrona/kryptokrona-api";
const repoPath = "https://github.com/kryptokrona/kryptokrona-api";

let octokit;
let token = process.env.PRIVATE_GITHUB_TOKEN;

if(token) {
    octokit = new Octokit({
        auth: token,
    });
}
else { 
    console.log("missing github token"); 
}

export async function getRepoStats() {
    try {
        const { data } = await octokit.request(endpoint);
        let stars = data.stargazers_count;
        let commits = await getCommits();
        let contributors = await getContributors();
        let latestCommit = { path : repoPath + "/commit/" + commits[0].sha, date: formatDate(new Date(commits[0].commit.author.date))};
        return {stars, version: 0.1, latestCommit, contributors }; 
    } catch (error) {
        console.error(error);
    }   
    return {};
}

async function getLatestVersion(){
    try {
        const { data } = await octokit.request(endpoint + "/releases")
        return data;
    } catch (error) {
        console.error(error);
    }
    return {};
}

async function getCommits() {
    try {
        const { data } = await octokit.request(endpoint + "/commits");
        return data;
    } catch(error) {
        console.error(error);
    }
  
    return [];  
}

async function getContributors() {
    try {
        const { data } = await octokit.request(endpoint + "/contributors");
        return data;
    } catch (error) {
        console.error(error);
    }
    return [];
}