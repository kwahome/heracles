module.exports = {
    roots: ['<rootDir>/src'],
    transform: {
        '^.+\\.tsx?$': 'ts-jest',
    },
    testRegex: '(/__tests__/.*|(\\.|/)(test|spec))\\.tsx?$',
    moduleFileExtensions: ['ts', 'tsx', 'js', 'jsx', 'json', 'node'],
    globals: {
        "ts-jest": {
            tsConfig: "<rootDir>/tsconfig.test.json",
        }
    },
    "moduleNameMapper": {
        "^.+\\.(css|less|scss)$": "identity-obj-proxy",
        "^services/(.*)$": "/src/services/$1",
    },
    testPathIgnorePatterns: ['test-setup.tsx'],

    // The test environment that will be used for testing
    testEnvironment: 'jsdom',
}
