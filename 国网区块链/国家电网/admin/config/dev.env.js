var merge = require('webpack-merge')
var prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  // API_ROOT: '"http://sciymd.natappfree.cc"',
  API_ROOT: '"http://127.0.0.1:80"',
  API_IMAGE: '"http://127.0.0.1:9100"'
})
