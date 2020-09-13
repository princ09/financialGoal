# financialGoal
Financial Goal mini Application Using Angular Material and Spring Boot.


## How to Run
1. Import Financial-Goals(Server) in eclipse, Run as Application.
1. Open finGoalClient in CommandLine and follow commands (Assuming Node.js Installed)
    1. ``` npm install ```
    2. ```ng serve```
## Technology/Framework/Lib Used
1. MySQL => Database
1. Java => Backend Languange
1. Spring Boot => Backend Framework
1. HTML and CSS => fronend markup and style
1. Angular => Frontend framework
1. Angular Material => Frontend Angular Library
1. notifier => Angular Notification Library
## Done
1. Add Goal
1. Remove Goal
1. Add Saving For Indiviual Goal
1. Show all Goal
1. Show Savings for Each Goal
1. Search Goal
### Limitation
#### 1. It Sending Request Every Second for getting Update
###### Alternatives
1. Use ``` window.location.reload()```
2. Use Router for component navigation and add following Snippet for Refreshing component 
```this.router.navigateByUrl('/RefreshComponent', { skipLocationChange: true }).then(() => { this.router.navigate(['Your actualComponent']); });```
3. Reload Manually
#### 2. Close and Open again Savings Model for updates.

### Known Issues
#### When only one Goal left in list , Remove button won't work.
Above alternatives can solve this issues. this issues occuring because when goal list get empty , server throws exception so success block not running.
