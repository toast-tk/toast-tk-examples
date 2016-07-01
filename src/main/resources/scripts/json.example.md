$fluxJson:=file('scripts/data/flux.json')

|| scenario || service ||
| @service:json-adapter Integrate *$fluxJson* |