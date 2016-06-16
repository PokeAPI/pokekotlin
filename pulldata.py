#!/usr/bin/env python3

import sys, requests, os, os.path

def safe_open_w(path):
    os.makedirs(os.path.dirname(path), exist_ok=True)
    return open(path, "w")

# Config

if len(sys.argv) != 2:
    print('Usage: pulldata <targetDir>', file=sys.stderr)
    quit(1)

baseUrl = "http://127.0.0.1:8000/"
targetDir = sys.argv[1]

if (not targetDir.endswith("/")):
    targetDir = targetDir + "/"

# Root

url = baseUrl + "api/v2/"
endpoints = requests.get(url)

path = targetDir + url.replace(baseUrl, '') + "index.json"
print(path)
print(endpoints.text, file=safe_open_w(path))

# Endpoints

for endpoint in endpoints.json().values():
    # Default index
    url = endpoint
    resourcelist = requests.get(url)
    path = targetDir + endpoint.replace(baseUrl, '') + "index.json"
    print(path)
    print(resourcelist.text, file=safe_open_w(path))
    
    # Fifty index
    url = endpoint + "?limit=50"
    resourcelist = requests.get(url)
    path = targetDir + endpoint.replace(baseUrl, '') + "limit=50.json"
    print(path)
    print(resourcelist.text, file=safe_open_w(path))

    # Zero index    
    url = endpoint + "?limit=0"
    resourcelist = requests.get(url)
    path = targetDir + endpoint.replace(baseUrl, '') + "limit=0.json"
    print(path)
    print(resourcelist.text, file=safe_open_w(path))
    
    # All index
    count = str(resourcelist.json()["count"])
    url = endpoint + "?limit=" + count
    resourcelist = requests.get(url)
    path = targetDir + endpoint.replace(baseUrl, '') + "limit=" + count + ".json"
    print(path)
    print(resourcelist.text, file=safe_open_w(path))
    
    # All resources
    for resourceSummary in resourcelist.json()['results']:
        resourceUrl = resourceSummary['url']
        path = targetDir + resourceUrl.replace(baseUrl, '') + "index.json"
        
        if not os.path.isfile(path):
            print(path)
            resource = requests.get(resourceUrl)
            print(resource.text, file=safe_open_w(path))
        
        if endpoint.endswith("/pokemon/"):
            resourceUrl = resourceUrl + "encounters/"
            path = targetDir + resourceUrl.replace(baseUrl, '') + "index.json"
            if not os.path.isfile(path):
                print(path)
                resource = requests.get(resourceUrl)
                print(resource.text, file=safe_open_w(path))








