## 1.0.0
<i>Initial release</i>
* Originally based on [tomsiewert/hetznercloud-java](https://github.com/tomsiewert/hetznercloud-java) with major refactoring (>95% of codebase):
  * Removed unused/dead code
  * Fixed some API inconsistencies (e.g. ``long/int64`` used for ports)
  * Break APIs down into their own classes. That way not everything needs to be in one monstrosity of a class and OOP is usable
  * Use Java records (requires Java 17+) and Builders
  * Deduplicate/Abstract a lot of code
  * Rewrote tests
  * Automated workflows, Checkstyle, formatting, static code analysis and much more...
