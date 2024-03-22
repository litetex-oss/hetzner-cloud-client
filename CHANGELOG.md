## 1.0.0
<i>Initial release</i>
* Based on [tomsiewert/hetznercloud-java](https://github.com/tomsiewert/hetznercloud-java) with major refactoring:
  * Removed unused/dead code
  * Fixed some API inconsistencies (e.g. ``long/int64`` used for ports)
  * Break APIs down into there own classes that way not everything needs to be in one monstrosity of a class and OOP can also be used
  * Use Java records and Builders
  * Deduplicate/Abstract a lot of code
