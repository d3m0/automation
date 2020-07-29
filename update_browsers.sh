cat config/browsers.json | jq -r '..|.image?|strings' | xargs -I{} docker pull {}
