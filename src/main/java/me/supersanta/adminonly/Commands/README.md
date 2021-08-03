# AdminOnly
A simple, lightweight, and configurable staff chat plugin built for 1.17.x.

config.yml is where you can set up your custom messages. The %player% variable can be used to display the players name, and `%message%` variable can be used to display the message sent. Color codes are supported!

## config.yml:
```
AOMessage: "&7[&4AO&7]&3 %player%&7: &d%message%"
VerboseOn: "&7[&4AO&7] &dVerbose on"
VerboseOff: "&7[&4AO&7] &dVerbose off"
JoinLeaveMessages: true
JoinMessage: "&7[&4AO&7] &a+ &3%player%"
LeaveMessage: "&7[&4AO&7] &c- &3%player%"
```

## Permissions 
`adminOnly.use` - Allows for `/ao` to be used

`adminOnly.see` - Allows messages sent in ao to be seen

`adminOnly.joinLeave` - Shows the players join message in ao

## Usage 
`/ao` - Toggles Verbose 

`/ao <message>` - Sends a message in ao 