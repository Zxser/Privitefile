var merge = require('webpack-merge')
var prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  // API_ROOT: '"http://sciymd.natappfree.cc"',
  API_ROOT: '"http://192.168.1.147:80"',
  API_IMAGE: '"http://192.168.1.147:9100"'
})

