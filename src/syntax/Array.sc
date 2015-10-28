val nums = Array.fill(100)(math.random)

nums.map(e => e*e).filter(_ < 0.25).sum // each time every new method create a new temporary collection
// how to avoid this?
nums.view.map(e => e*e).filter(_ < 0.25).sum // this is how